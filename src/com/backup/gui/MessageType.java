package com.backup.gui;

import javax.swing.ImageIcon;

/**
 * @author Allan Jacques
 */
public enum MessageType {

    SUCCESSFULLY_MESSAGE(new ImageIcon(MessageType.class.getResource("images/correct25.png"))),
    UNSUCCESSFULLY_MESSAGE(new ImageIcon(MessageType.class.getResource("images/incorrect25.png"))),
    CLEAN_MESSAGE(new ImageIcon(MessageType.class.getResource("")));

    MessageType(final ImageIcon icon) {
        this.icon = icon;
    }

    private final ImageIcon icon;

    public ImageIcon getIcon() {
        return icon;
    }

}
