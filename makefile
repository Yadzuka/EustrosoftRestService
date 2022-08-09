usage:
	@echo "make package -> for build"
	@echo "make run -> for run"
	@echo "P.S. make sure that you have all env variables"

package:
	mvn clean package

run:
	java -jar -noverify target/RestServer-0.0.1-SNAPSHOT.jar