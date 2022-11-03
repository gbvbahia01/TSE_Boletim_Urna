package com.gbvbahia.tre.util;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.FileSystemResource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IOHelper {

  public static Collection<File> listFilesRecursive(String dir, String extension) {
    return FileUtils.listFiles(new File(dir), new String[] {extension}, true);
  }
  
  public static void zipAndMoveFileToFolder(String file, String folderName) {
    File toZip = new FileSystemResource(file).getFile();
    try {
      File zip = Compactator.zip(toZip, toZip.getName());
      File dir = new File(toZip.getAbsoluteFile().getParent(), folderName);
      dir.mkdir();
      FileUtils.moveFileToDirectory(zip, dir, true);
      FileUtils.deleteQuietly(toZip);
    } catch (IOException io) {
      String error = String.format("Error trying to ZIP the file: %s", file);
      log.error(error, io);
    }
  }
}