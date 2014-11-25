package com.backup.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Allan Jacques
 */
public class SessionList implements Serializable {

    private List<Session> sessions;

    public SessionList() {
        this.sessions = new ArrayList<Session>();
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

}
