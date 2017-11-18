package io.jtelegram.api.message.media;

import lombok.Getter;

@Getter
public class Audio extends FileMedium implements DuratableMedium, MimeableMedium {
    private int duration;
    private String performer;
    private String title;
    private String mimeType;
}