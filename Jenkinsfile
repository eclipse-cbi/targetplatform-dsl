pipeline {
  agent {
    label 'centos-latest'
  }

  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
    checkoutToSubdirectory('scm')
    disableConcurrentBuilds()
    timestamps()
  }

  tools {
    maven 'apache-maven-latest'
    jdk 'temurin-jdk17-latest'
  }

  environment {
    PUBLISH_LOCATION = 'cbi/updates'
  }

  parameters {
    choice(
      name: 'BUILD_TYPE',
      choices: ['nightly', 'milestone', 'release'],
      description: '''
        Choose the type of build.
        Note that a release build will not promote the build, but rather will promote the most recent milestone build.
      '''
    )

    booleanParam(
      name: 'PROMOTE',
      defaultValue: true,
      description: 'Whether to promote the build to the download server.'
    )

    booleanParam(
      name: 'ARCHIVE',
      defaultValue: false,
      description: 'Whether to archive the workspace.'
    )
  }

  stages {
    stage('Display Parameters') {
      steps {
        script {
          env.BUILD_TYPE = params.BUILD_TYPE
          if (env.BRANCH_NAME == "master") {
           // Only promote and sign the master branch.
           //
           env.PROMOTE = params.PROMOTE
          } else {
           // Do not promote and sign PR builds.
           env.PROMOTE = false
          }
          def description = """
BUILD_TYPE=${params.BUILD_TYPE}
PROMOTE=${env.PROMOTE}
ARCHIVE=${params.ARCHIVE}
""".trim()
          echo description
          currentBuild.description = description.replace("\n", "<br/>")
          env.PROMOTE = params.PROMOTE
          env.BUILD_TYPE = params.BUILD_TYPE
        }
       }
    }

    stage('Build') {
      steps {
        dir('scm') {
          sshagent(['projects-storage.eclipse.org-bot-ssh']) {
            wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
              sh '''
                if [[ $PROMOTE == false ]]; then
                  promotion_argument='-Dorg.eclipse.justj.p2.manager.args='
                else
                  promotion_argument='-Peclipse-sign -Dpromote=true'
                fi
                mvn \
                 -B \
                 -Ptarget-default \
                  $promotion_argument \
                 -Dorg.eclipse.storage.user=genie.cbi \
                 -Dorg.eclipse.justj.p2.manager.build.url=$JOB_URL \
                 -Dorg.eclipse.download.location.relative=$PUBLISH_LOCATION \
                 -Dorg.eclipse.justj.p2.manager.relative= \
                 -Dbuild.type=$BUILD_TYPE \
                 -Dgit.commit=$GIT_COMMIT \
                 -Dbuild.id=$BUILD_NUMBER \
                 clean \
                 install \
              '''
            }
          }
        }
      }
    }

    stage('Archive Results') {
      when {
        expression {
          params.ARCHIVE
        }
      }
      steps {
        archiveArtifacts 'scm/**'
      }
    }
  }

  post {
    failure {
      mail to: 'ed.merks@gmail.com',
       subject: "[CBI-TPD] Build Failure ${currentBuild.fullDisplayName}",
       mimeType: 'text/html',
       body: "Project: ${env.JOB_NAME}<br/>Build Number: ${env.BUILD_NUMBER}<br/>Build URL: ${env.BUILD_URL}<br/>Console: ${env.BUILD_URL}/console"
    }
    fixed {
      mail to: 'ed.merks@gmail.com',
       subject: "[CBI-TPD] Back to normal ${currentBuild.fullDisplayName}",
       mimeType: 'text/html',
       body: "Project: ${env.JOB_NAME}<br/>Build Number: ${env.BUILD_NUMBER}<br/>Build URL: ${env.BUILD_URL}<br/>Console: ${env.BUILD_URL}/console"
    }
  }
}
