package com.huanggit.enumeration.common;

/**
 * Created by huang on 2017-11-16-0016.
 */
public enum Country {
    //http://www.jctrans.com/tool/gjym.htm
    Afghanistan("AF","阿富汗"),
    Albania("AL","阿尔巴尼亚"),
    Algeria("DZ","阿尔及利亚"),
    Andorra("AD","安道尔"),
    Angola("AO","安哥拉"),
    AntiguaAndBarbuda("AG","安提瓜和巴布达"),
    Argentina("AR","阿根廷"),
    Armenia("AM","亚美尼亚"),
    Australia("AU","澳大利亚"),
    Austria("AT","奥地利"),
    Azerbaijan("AZ","阿塞拜疆"),
    UnitedArabEmirates("AE","阿联酋"),
    Montenegro("ME","黑山"),
    Barbados("BB","巴巴多斯"),
    Bangladesh("BD","孟加拉国"),
    Belgium("BE","比利时"),
    BurkinaFaso("BF","布基纳法索"),
    Bulgaria("BG","保加利亚"),
    Bahrain("BH","巴林"),
    Burundi("BI","布隆迪"),
    Benin("BJ","贝宁"),
    Brunei("BN","文莱"),
    Bolivia("BO","玻利维亚"),
    Brazil("BR","巴西"),
    TheBahamas("BS","巴哈马"),
    Bhutan("BT","不丹"),
    Botswana("BW","博茨瓦纳"),
    Belarus("BY","白俄罗斯"),
    China("CN","中国");

    private Country(String simplfiedCode,String chineseName) {
        this.simplfiedCode = simplfiedCode;
        this.chineseName = chineseName;
    }

    private final String simplfiedCode;
    private final String chineseName;

    public String getSimplfiedCode() {
        return simplfiedCode;
    }

    public String getChineseName() {
        return chineseName;
    }

    public static final int COUNTRY_SIZE = Country.values().length;
}
