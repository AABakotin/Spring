package com.geekbrains.lesson9.repositories.interfaces;




import com.geekbrains.lesson9.entites.FileMetaDTO;

import java.util.Collection;
import java.util.UUID;

public interface IFileMetaProvider {

    String checkFileExists(UUID fileHash);

    /**
     * Сохранить метаданные файла
     *
     */
    void saveFileMeta(UUID Hash, String fileName, int sybType);

    int deleteMetaFile(UUID fileHash);

    Collection<FileMetaDTO> getMetaFiles(int subtype);
}
