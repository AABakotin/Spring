package com.geekbrains.lesson9.services;


import com.geekbrains.lesson9.entites.FileMetaDTO;
import com.geekbrains.lesson9.repositories.interfaces.IFileMetaProvider;
import com.geekbrains.lesson9.repositories.interfaces.IFileSystemProvider;
import com.geekbrains.lesson9.services.interfaces.IFileStoreService;
import com.geekbrains.lesson9.utils.HashHelper;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.UUID;

@Component
public class FileStoreService implements IFileStoreService {

    @Autowired
    IFileSystemProvider systemProvider;

    @Autowired
    IFileMetaProvider fileMetaProvider;

    @Override
    public String storeFile(byte[] content, String fileName, int subFileType) throws IOException, NoSuchAlgorithmException {
        final UUID md5 = HashHelper.getMd5Hash(content);

        String filename = fileMetaProvider.checkFileExists(md5);
        if (filename == null) {
            fileMetaProvider.saveFileMeta(md5, fileName, subFileType);
            filename = systemProvider.storeFile(content, md5, fileName);
        }

        return filename;
    }

    @Override
    public byte[] getFile(UUID md5) throws IOException {
        String filename = fileMetaProvider.checkFileExists(md5);
        String ext = FilenameUtils.getExtension(filename);
        String fullFileName = md5.toString() + "." + ext;
        return systemProvider.getFile(fullFileName);
    }

    @Override
    public Collection<FileMetaDTO> getMetaFiles(int subtype) {
        return fileMetaProvider.getMetaFiles(subtype);
    }


    // В любом случае удаляем запись из БД.
    // Если после удаления осталась хоть одна запись о файле, файл не трогаем.
    // Если нет записей в бд, то удаляем файл.
    public String deleteFiles(UUID md5) {
        String filename = fileMetaProvider.checkFileExists(md5);
        String ext = FilenameUtils.getExtension(filename);
        String fullFileName = md5.toString() + "." + ext;
        if (fileMetaProvider.deleteMetaFile(md5) < 0) {
            try {
                systemProvider.deleteFile(fullFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "delete file" + fullFileName;
        }
        return "delete meta" + fullFileName;
    }


}
