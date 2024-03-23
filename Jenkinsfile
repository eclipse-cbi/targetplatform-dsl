pipeline {
    agent {
        label 'jipp-migration'
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
            defaultValue: false,
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
                    def description = """
BUILD_TYPE=${params.BUILD_TYPE}
PROMOTE=${params.PROMOTE}
ARCHIVE=${params.ARCHIVE}
GIT_COMMIT=${env.GIT_COMMIT}
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

/*
        stage('Tests against 4.5 - Mars') {
            steps {
                dir('4.5') {
                    sh 'cp -rf ../scm/* . && cp -rf ../scm/.git .'
                    wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
                        sh 'mvn -B clean verify -Ptarget-4_5-mars'
                    }
                }
            }
        }
        stage('Tests against 4.6 - Neon') {
            steps {
                dir('4.6') {
                    sh 'cp -rf ../scm/* . && cp -rf ../scm/.git .'
                    wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
                        sh 'mvn -B clean verify -Ptarget-4_6-neon'
                    }
                }
            }
        }
        stage('Tests against 4.7 - Oxygen') {
            steps {
                dir('4.7') {
                    sh 'cp -rf ../scm/* . && cp -rf ../scm/.git .'
                    wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
                        sh 'mvn -B clean verify -Ptarget-4_7-oxygen'
                    }
                }
            }
        }
        stage('Tests against 4.8 - Photon') {
            steps {
                dir('4.8') {
                    sh 'cp -rf ../scm/* . && cp -rf ../scm/.git .'
                    wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
                        sh 'mvn -B clean verify -Ptarget-4_8-photon'
                    }
                }
            }
        }
*/

/*
        stage('Deploy') {
            steps {
                dir('scm') {
                    sshagent ( ['projects-storage.eclipse.org-bot-ssh']) {
                      sh '''
                        POM_VERSION=$(mvn -q -Dexec.executable="echo" -Dexec.args='${project.version}' --non-recursive org.codehaus.mojo:exec-maven-plugin:3.1.0:exec)
                        DEPLOY_PATH="/home/data/httpd/download.eclipse.org/cbi/tpd/${POM_VERSION}"
                        ssh genie.cbi@projects-storage.eclipse.org<<ENDSSH 
                            mkdir -p "${DEPLOY_PATH}.new"
                            rm -rf "${DEPLOY_PATH}.new/*"
ENDSSH
                        scp org.eclipse.cbi.targetplatform-update/target/org.eclipse.cbi.targetplatform-*.zip genie.cbi@projects-storage.eclipse.org:"${DEPLOY_PATH}.new/"
                        scp -r org.eclipse.cbi.targetplatform-update/target/repository/* genie.cbi@projects-storage.eclipse.org:"${DEPLOY_PATH}.new/"
                        ssh genie.cbi@projects-storage.eclipse.org <<ENDSSH
                            mv "${DEPLOY_PATH}" "${DEPLOY_PATH}.old"
                            mv "${DEPLOY_PATH}.new" "${DEPLOY_PATH}"
                            rm -rf "${DEPLOY_PATH}.old"
ENDSSH
                      '''
                    }
                }
            }
        }
*/
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
            mail to: 'releng-team@eclipse-foundation.org',
              subject: "[CBI-TPD] Build Failure ${currentBuild.fullDisplayName}",
              mimeType: 'text/html',
              body: "Project: ${env.JOB_NAME}<br/>Build Number: ${env.BUILD_NUMBER}<br/>Build URL: ${env.BUILD_URL}<br/>Console: ${env.BUILD_URL}/console"
        }
        fixed {
            mail to: 'releng-team@eclipse-foundation.org',
              subject: "[CBI-TPD] Back to normal ${currentBuild.fullDisplayName}",
              mimeType: 'text/html',
              body: "Project: ${env.JOB_NAME}<br/>Build Number: ${env.BUILD_NUMBER}<br/>Build URL: ${env.BUILD_URL}<br/>Console: ${env.BUILD_URL}/console"
        }
    }
}
