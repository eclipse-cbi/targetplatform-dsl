pipeline {
    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
        checkoutToSubdirectory('scm')
        timestamps()
    }

    triggers { pollSCM('H * * * *') }

    tools {
        maven 'apache-maven-latest' 
    }

    stages {
        stage('Build') {
            steps {
                dir('scm') {
                    wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
                        sh 'mvn -B clean install -Ptarget-default'
                    }
                }
            }
        }
        stage('Test') {
            parallel {
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
            }
        }
        stage('Deploy') {
            steps {
                dir('scm') {
                    sh '''
                        POM_VERSION=$(mvn -q -Dexec.executable="echo" -Dexec.args='${project.version}' --non-recursive org.codehaus.mojo:exec-maven-plugin:1.6.0:exec)
                        rm -rf /home/data/httpd/download.eclipse.org/cbi/tdp/${POM_VERSION}
                        mkdir -p /home/data/httpd/download.eclipse.org/cbi/tdp/${POM_VERSION}
                        cp -rf org.eclipse.cbi.targetplatform-update/target/repository/* /home/data/httpd/download.eclipse.org/cbi/tdp/${POM_VERSION}
                        cp org.eclipse.cbi.targetplatform-update/target/org.eclipse.cbi.targetplatform-*.zip /home/data/httpd/download.eclipse.org/cbi/tdp/${POM_VERSION}/
                    '''
                }
            }
        }
    }

    post { 
        always { 
            cleanWs()
        }
    }
}
