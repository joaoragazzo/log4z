package com.log4z.parsers;

public class RegexBook {

    /*
        Default header for logs
    */

    public static final String DefaultDateHeader = "\\[(\\d{2})-(\\d{2})-(\\d{4})\\].*";


    /*
        C4 Parsers
    */
    public static final String C4Regex = "\\[(.*?)\\]\\s*\\[(.*?)\\]\\s*\\[(.*?)\\]\\s*(.*?)\\| (.*?), Position: <(.*?), (.*?), (.*?)>, Target: (.*?) \\| Player: (.*?) \\[76(.*?)\\]";


    /*
        Hacksaw parsers
    */

    public static final String HacksawHeader = "\\[\\d{2}-\\d{2}-\\d{4}]\\[\\d{2}\\.\\d{2}\\.\\d{2}] New Raid Log File Created!";
    public static final String HacksawBody = "\\[(\\d{2}):(\\d{2}):(\\d{2})\\] Player \\((.+)\\, (\\d+)\\)\\(<(\\d+\\.\\d+), (\\d+\\.\\d+), (\\d+\\.\\d+)>\\) is raiding lock! CodeLock HP: (\\d+) Damage Done: (\\d+)";
    public static final String HacksawBodySuccess = "\\[(\\d{2}):(\\d{2}):(\\d{2})\\] Player \\((.+)\\, (\\d+)\\)\\(<(\\d+\\.\\d+), (\\d+\\.\\d+), (\\d+\\.\\d+)>\\) successfully raided lock!";


    /*
        Attach lock
    */

    public static final String AttachLockHeader = "\\[\\d{2}-\\d{2}-\\d{4}]\\[\\d{2}\\.\\d{2}\\.\\d{2}] New Attach Log File Created!";
    public static final String AttachLockBody = "\\[(\\d{2}):(\\d{2}):(\\d{2})\\] Player \\((.+)\\, (\\d+)\\)\\(<(\\d+\\.\\d+), (\\d+\\.\\d+), (\\d+\\.\\d+)>\\) attached a lock!";

    /*
        Access lock
    */

    public static final String AccessLockHeader = "\\[\\d{2}-\\d{2}-\\d{4}]\\[\\d{2}\\.\\d{2}\\.\\d{2}] New Access Log File Created!";
    public static final String AccessLockBody = "\\[(\\d{2}):(\\d{2}):(\\d{2})\\] Player \\((.+)\\, (\\d+)\\)\\(<(\\d+\\.\\d+), (\\d+\\.\\d+), (\\d+\\.\\d+)>\\) (.*)!";

}
