import java.io.File;

public class HtmlFileDeleter{
    public static void main(String[] args) {
        String rootDirectoryPath = "/home/bandi16/Documents/projekt/projekt/kepek";

        File rootDirectory = new File(rootDirectoryPath);
        
        if (rootDirectory.isDirectory()) {
            deleteHTMLFiles(rootDirectory);
            System.out.println("Torles befejezve");
        } else {
            System.out.println("A megadott utvonal nem egy konyvtar.");
        }
    }

    private static void deleteHTMLFiles(File directory) 
    {
        File[] files = directory.listFiles();
        
        if (files != null) 
        {
            for (File file : files) 
            {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".html")) 
                {
                    boolean deleted = file.delete();
                    if (deleted) {
                        System.out.println("Deleted file: " + file.getAbsolutePath());
                    } else 
                    {
                        System.out.println("Failed to delete file: " + file.getAbsolutePath());
                    }
                } 
                else if (file.isDirectory()) 
                {
                    deleteHTMLFiles(file);
                }
            }
        } 
        else 
        {
            System.out.println("The directory is empty: " + directory.getAbsolutePath());
        }
    }
}
