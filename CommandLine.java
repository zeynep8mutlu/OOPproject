public class CommandLine {
    private SystemLibrary library;

    public CommandLine(SystemLibrary library) {
        this.library = library;
    }

    public void execute(String commandLine) {
        String[] parts = commandLine.trim().split(" ");
        if (parts.length == 0) return;
        String command = parts[0];
        switch (command) {
            case "help":
                System.out.println("Commands:");
                System.out.println("open <file>        - open and load file");
                System.out.println("close              - close the currently opened file");
                System.out.println("save               - save to the currently opened file");
                System.out.println("saveas <file>      - save to a new file");
                System.out.println("help               - prints this information" );
                System.out.println("exit               - exit the program");
                break;

            case "open":
                if (parts.length < 2) {
                    System.out.println("open <file>");
                } else {
                    library.openFile(parts[1]);
                }
                break;
            case "save":
                library.saveFile();
                break;
            case "saveas":
                if (parts.length < 2) {
                    System.out.println("saveas <file>");
                } else {
                    library.saveFileAs(parts[1]);
                }
                break;
            case "close":
                library.closeFile();
                break;
            case "exit":
                System.out.println("Exiting the program...");
                System.exit(0);
                break;
            default:
                System.out.println("Help for command list");
        }
    }
}
