package com.log4z.parsers;

public class RegexBook {

    public static final String C4Regex = "\\[(.*?)\\]\\s*\\[(.*?)\\]\\s*\\[(.*?)\\]\\s*(.*?)\\| (.*?), Position: <(.*?), (.*?), (.*?)>, Target: (.*?) \\| Player: (.*?) \\[76(.*?)\\]";


    public static final String HacksawHeader = "\\[\\d{2}-\\d{2}-\\d{4}]\\[\\d{2}\\.\\d{2}\\.\\d{2}] New Raid Log File Created!";

    public static final String HacksawDate = "\\[(\\d{2})-(\\d{2})-(\\d{4})\\].*";
    public static final String HacksawBody = "\\[(\\d{2}):(\\d{2}):(\\d{2})\\] Player \\((.+)\\, (\\d+)\\)\\(<(\\d+\\.\\d+), (\\d+\\.\\d+), (\\d+\\.\\d+)>\\) is raiding lock! CodeLock HP: (\\d+) Damage Done: (\\d+)";
    public static final String HacksawBodySuccess = "\\[(\\d{2}):(\\d{2}):(\\d{2})\\] Player \\((.+)\\, (\\d+)\\)\\(<(\\d+\\.\\d+), (\\d+\\.\\d+), (\\d+\\.\\d+)>\\) successfully raided lock!";
}
