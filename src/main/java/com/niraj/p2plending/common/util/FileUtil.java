package com.niraj.p2plending.common.util;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


/**
 * File related utility methods.
 */
public final class FileUtil {


    private FileUtil() {
    }



    /**
     * Generates unique filename.
     *
     * @param originalName original filename
     * @return unique filename
     */
    public static String generateUniqueFileName(
            String originalName
    ) {

        String extension = "";


        if(originalName != null
                && originalName.contains(".")) {

            extension =
                    originalName.substring(
                            originalName.lastIndexOf(".")
                    );

        }


        return UUID.randomUUID()
                + extension;

    }



    /**
     * Checks whether file exists.
     */
    public static boolean isEmpty(
            MultipartFile file
    ) {

        return file == null
                || file.isEmpty();

    }

}