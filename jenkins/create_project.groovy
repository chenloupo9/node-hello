job('NodeJS Docker example') {
    scm {
        git('git://https://github.com/nlitterat/node-hello.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('nlitterat')
            node / gitConfigEmail('nlitterat@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('Node 17.0.1') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('nlitterat/compie')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}

