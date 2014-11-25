package com.backup.io;

import com.backup.app.MyApp;
import com.backup.bean.ScheduledBackup;
import com.backup.bean.Session;
import com.backup.utils.FileUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author Allan Jacques
 */
public class SystemFileHandler {

    private final File configFile;
    private static SystemFileHandler systemFileHandler;

    private SystemFileHandler() throws FileNotFoundException, IOException {
        this.configFile = FileUtils.getSystemFile();
    }

    public static SystemFileHandler getInstance() {
        if (systemFileHandler == null) {
            try {
                systemFileHandler = new SystemFileHandler();
            } catch (IOException ex) {
                MyApp.log(Level.SEVERE, null, ex);
                throw new RuntimeException(ex);
            }
        }
        return systemFileHandler;
    }

    public SystemFile load() throws RuntimeException {
        try {
            MyApp.log(Level.INFO, "Loading configuration file...");
            JAXBContext context = JAXBContext.newInstance(SystemFile.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            SystemFile systemFile = (SystemFile) unmarshaller.unmarshal(this.configFile);
            return systemFile;
        } catch (JAXBException ex) {
            MyApp.log(Level.INFO, "Configuration file not found");
            throw new RuntimeException(ex);
        }

    }

    public void save() throws RuntimeException {
        try {
            MyApp.log(Level.INFO, "Saving configuration file...");
            JAXBContext context = (JAXBContext) JAXBContext.newInstance(SystemFile.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.marshal(MyApp.getSystemFile(), this.configFile);
        } catch (JAXBException ex) {
            MyApp.log(Level.INFO, "Configuration file not found");
            throw new RuntimeException(ex);
        }

    }

    public void alterSession(Session currentSession, Session sessionTemp) {
        for (ScheduledBackup sbTemp : MyApp.getSystemFile().getScheduledBackupList().getScheduledBackups()) {
            if (sbTemp.getSession().equals(currentSession)) {
                sbTemp.setSession(sessionTemp);
            }
        }

    }
}
