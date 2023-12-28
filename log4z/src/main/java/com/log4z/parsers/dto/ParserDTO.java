package com.log4z.parsers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class ParserDTO {

    public Float x, y, z;
    public String steamId;
    public String nickname;
    public String information;
    public String iconUrl;
    public String date;
    public String kills;

}
