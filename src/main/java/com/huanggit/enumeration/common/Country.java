package com.huanggit.enumeration.common;

/**
 * Created by huang on 2017-11-16-0016.
 */
public enum Country {

    Afghanistan("AFG","阿富汗"),
    Albania("ALB","阿尔巴尼亚"),
    Algeria("DZA","阿尔及利亚"),
    Andorra("AND","安道尔"),
    Angola("AGO","安哥拉"),
    AntiguaAndBarbuda("ATG","安提瓜和巴布达"),
    Argentina("ARG","阿根廷"),
    Armenia("ARM","亚美尼亚"),
    Australia("AUS","澳大利亚"),
    Austria("AUT","奥地利"),
    Azerbaijan("AZE","阿塞拜疆"),
    UnitedArabEmirates("UAE","阿联酋"),
    BosniaAndHerzegovina("BIH","波黑"),
    Barbados("BRB","巴巴多斯"),
    Bangladesh("BGD","孟加拉国"),
    Belgium("BEL","比利时"),
    BurkinaFaso("BFA","布基纳法索"),
    Bulgaria("BGR","保加利亚"),
    Bahrain("BHR","巴林"),
    Burundi("BDI","布隆迪"),
    Benin("BEN","贝宁"),
    Brunei("BRN","文莱"),
    Bolivia("BOL","玻利维亚"),
    Brazil("BRA","巴西"),
    TheBahamas("BHS","巴哈马"),
    Bhutan("BTN","不丹"),
    Botswana("BWA","博茨瓦纳"),
    Belarus("BLR","白俄罗斯");

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
}
