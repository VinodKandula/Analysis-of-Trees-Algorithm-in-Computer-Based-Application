import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class Directory {

    private List<FileDescription> fileDescriptionList;



    //Constructor
    public Directory(File file)
    {
        fileDescriptionList = new LinkedList<>();
        loadFile(file);
        for (FileDescription description : fileDescriptionList) {
            System.out.println(description.getFileType() + ": " + description.getFileName() + " : " + description.getSourceDirectory() + " = " + description.getFileSize());
        }

        System.out.println();
    }

    public List<FileDescription> getFileDescriptionList() {
        return fileDescriptionList;
    }

    private void loadFile(File file)
    {
        if (file.isDirectory()) {
            File[] files = file.listFiles();

            for (File newFile : files) {
                FileDescription fileDescription = new FileDescription();
                String[] folders = newFile.getAbsolutePath().split("/");
                fileDescription.setFileName(folders[folders.length - 1]);
                fileDescription.setFileSize(newFile.length());
                StringBuilder sourceDirectory = new StringBuilder();
                for (int i = 0; i < folders.length - 1; i++) {
                    sourceDirectory.append(folders[i]).append("/");
                }
                fileDescription.setSourceDirectory(sourceDirectory.toString());

                if (newFile.isDirectory()) {

                    fileDescription.setFileType("FOLDER");
                    fileDescriptionList.add(fileDescription);
                } else {
                    fileDescription.setFileType("FILE");
                    fileDescription.setFileName(folders[folders.length - 1]);
                    fileDescriptionList.add(fileDescription);

                }
            }
        } else {
            FileDescription fileDescription = new FileDescription();
            String[] folders = file.getAbsolutePath().split("/");
            StringBuilder sourceDirectory = new StringBuilder();
            for (int i = 0; i < folders.length - 1; i++) {
                sourceDirectory.append(folders[i]).append("/");
            }
            fileDescription.setSourceDirectory(sourceDirectory.toString());
            fileDescription.setFileType("FILE");
            fileDescription.setFileName(folders[folders.length - 1]);
            fileDescription.setFileSize(file.length());
            fileDescriptionList.add(fileDescription);

        }
    }
}
