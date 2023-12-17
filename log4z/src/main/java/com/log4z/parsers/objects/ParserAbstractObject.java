package com.log4z.parsers.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class ParserAbstractObject {

    private float x, y, z;
    public String steamId;
    public String nickname;
    public String information;
    public String iconUrl;


}
