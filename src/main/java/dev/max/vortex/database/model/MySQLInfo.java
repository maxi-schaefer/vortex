package dev.max.vortex.database.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MySQLInfo {
    private final String host;
    private final int port;
    private final String database;
    private final String user;
    private final String password;
}