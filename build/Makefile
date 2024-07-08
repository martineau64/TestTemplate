all:
	javac -d ../lib ../src/Example.java
	javac -cp ../lib -d . ../src/Main.java
	javac -cp ../lib -d ../target ../test/*

run:
	java -cp .:../lib Main

doc:
	javadoc -d ../doc ../src/*

test:
	# Add Unit Testing: java -cp ../target:../lib [TestName]

clean:
	rm -f *.class
	rm -f -R ../doc/*
	rm -f -R ../lib/*
	rm -f -R ../target/*
