#!/usr/bin/env groovy

def call() {
    echo "building the docker image...."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t alexdevops31/jenkins-demo-app:jda-2.0 ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push alexdevops31/jenkins-demo-app:jda-2.0"
    }
}
