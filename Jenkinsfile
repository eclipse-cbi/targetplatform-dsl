pipeline {
    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
        checkoutToSubdirectory('scm')
        timestamps()
    }

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
                            sh 'cp -rf ../scm/* .'
                            wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
                                sh 'mvn -B clean verify -Ptarget-4_5-mars'
                            }
                        }
                    }
                }
                stage('Tests against 4.6 - Neon') {
                    steps {
                        dir('4.6') {
                            sh 'cp -rf ../scm/* .'
                            wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
                                sh 'mvn -B clean verify -Ptarget-4_6-Neon'
                            }
                        }
                    }
                }
                stage('Tests against 4.7 - Oxygen') {
                    steps {
                        dir('4.7') {
                            sh 'cp -rf ../scm/* .'
                            wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
                                sh 'mvn -B clean verify -Ptarget-4_7-oxygen'
                            }
                        }
                    }
                }
                stage('Tests against 4.8 - Photon') {
                    steps {
                        dir('4.8') {
                            sh 'cp -rf ../scm/* .'
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
                echo 'Deploying....'
            }
        }
    }

    post { 
        always { 
            cleanWs()
        }
    }
}
