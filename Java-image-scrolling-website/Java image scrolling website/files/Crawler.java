import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//vegig megy a direken es a fileokon
public class Crawler 
{

    public String path;

    public Crawler(String path) {
        this.path = path;
    }

    public void start() 
    {   //uj file objektum
        File dir = new File(this.path);
        //megcsinalja az index.htlt abban a mappaban
        Index i = new Index(dir.getAbsolutePath());
        //index html kodja
        i.createPage();

        //jelenlegi mappa utvonala
        System.out.printf("\nCurrent folder: %s\n",  dir.getAbsolutePath());
        //tobbi mappa listazasa
        showFiles(dir.listFiles());
    }

    public void showFiles(File[] files) {

        List<String> fnames = new ArrayList<>();
        List<String> dirs = new ArrayList<>();

        for (File file : files) {


            if (file.isDirectory()) {
                dirs.add(file.getAbsolutePath());
                System.out.println("Current folder: " + file.getAbsolutePath());
                showFiles(file.listFiles()); // Calls same method again.
            } else {
                if(!file.getAbsolutePath().endsWith("index.html") && CommonUtils.isValid(file.getAbsolutePath())) {
                    fnames.add(file.getAbsolutePath());
                }
            }
        }

        Collections.sort(fnames);

        //visszalepes miatt
        fnames.add(0, "");
        fnames.add("");

        for(int i = 1; i < fnames.size() - 1; i++) {
            Page p = new Page(fnames.get(i - 1), fnames.get(i), fnames.get(i + 1));
            p.createPage();
        }

        for(String s : dirs) {
            Index i = new Index(s);
            i.createPage();
        }
    }
}