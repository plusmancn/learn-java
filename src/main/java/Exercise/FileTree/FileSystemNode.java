package Exercise.FileTree;

import java.util.ArrayList;
import java.util.List;

public class FileSystemNode {
    private String path;
    private boolean isFile;
    private List<FileSystemNode> subNodes = new ArrayList<>();

    public FileSystemNode(String path, boolean isFile) {
        this.path = path;
        this.isFile = isFile;
    }

    public int countNumOfFiles() {
        return 1;
    }

    public long countSizeOfFiles() {
        return 1024;
    }

    public String getPath() {
        return path;
    }

    public void addSubNode(FileSystemNode fileOrDir) {
        subNodes.add(fileOrDir);
    }

    /**
     * 未遍历，深度为 1
     * @param fileOrDir
     */
    public void removeSubNode(FileSystemNode fileOrDir) {
        int size = subNodes.size();
        int i = 0;
        for(; i < size; ++i) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())) {
                break;
            }
        }

        if(i < size) {
            subNodes.remove(i);
        }
    }

    
}
