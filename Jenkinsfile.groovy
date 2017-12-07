

pipeline {
	/* A declarative Pipeline */
	agent any 		
	
	stages {
		stage('Build'){
			steps {
				sh '/Users/acherkas/Mypart/Jenkins_learn/apache-maven-3.5.2/bin/mvn clean package'
			}

			post {
				success {
					echo 'Now Archiving...'
					archiveArtifacts artifacts: '**/target/*.war'
				}
			}
		}
	}
}
