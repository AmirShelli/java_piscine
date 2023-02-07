rm -rf target
mkdir target
javac src/java/printer/*/*.java -d ./target
java -classpath target edu.school21.printer.app.Program.java . 0 /home/mitsu/IdeaProjects/java_piscine/day04/src/image.bmp