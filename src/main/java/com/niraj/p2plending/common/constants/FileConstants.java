package com.niraj.p2plending.common.constants;


/**
 * File handling constants.
 */
public final class FileConstants {


    private FileConstants() {
    }


    public static final long MAX_FILE_SIZE_MB =
            5;


    public static final String[] ALLOWED_DOCUMENT_TYPES = {
            "jpg",
            "jpeg",
            "png",
            "pdf"
    };


}