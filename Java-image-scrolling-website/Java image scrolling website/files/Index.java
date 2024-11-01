import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//index htmlt csinalja meg mappankent
public class Index 
{
    private String path;

    public Index(String path) {
        this.path = path;
    }

    public void createPage() {
        try {
            FileWriter myWriter = new FileWriter(this.path + "/index.html");
            myWriter.write(getCode());
            myWriter.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    //beleirom az abban a mappban levo dirseket es fileokat
    public String getCode() {
        StringBuilder sb = new StringBuilder();
        List<String> dirs = listOfDirs(this.path);
        List<String> files = listOfFiles(this.path);
        sb.append("<!DOCTYPE html>\n<html>\n<body>\n");
        sb.append("\t<h1><a href=\"" + CommonUtils.getRelativePath(this.path + "/index.html") + "\">StartPage</a></h1>\n");
        sb.append("\t<hr>\n");
        sb.append("\t<p>Folders:</p>\n\t<ul>\n");
        //ha nem ez a fomappa -> visszalapes hivatkozas
        if(!CommonUtils.isRoot(path)) {
            sb.append("\t\t " + "<li><a href=\"../index.html" + "\"> " + "<<" + " </a></li>\n");
        }
        //beleirjuk a dirs nevet
        for(String s : dirs) {
            Linker d = new Linker(s);
            sb.append("\t\t " + d.toString());
        }
        sb.append("\t</ul>\n");
        sb.append("\t<hr>\n");
        sb.append("\t<p>Files:</p>\n\t<ul>\n");
        //file-ok nevenek beleirasa
        for(String s : files) {
            Linker f = new Linker(s);
            sb.append("\t\t " + f.toString());
        }
        sb.append("\t</ul>\n");
        sb.append("</body>\n</html>");
        return sb.toString();
    }

    public List<String> listOfFiles(String pth) {
        List<String> files = new ArrayList<>();
        for(File file : new File(pth).listFiles()) {
            if(file.isFile() && CommonUtils.isValid(file.getAbsolutePath())) {
                files.add(file.getAbsolutePath());
            }
        }
        Collections.sort(files);
        return files;
    }

    public List<String> listOfDirs(String pth) {
        List<String> dirs = new ArrayList<>();
        for(File file : new File(pth).listFiles()) {
            if(file.isDirectory()) {
                dirs.add(file.getAbsolutePath());
            }
        }
        Collections.sort(dirs);
        return dirs;
    }
}