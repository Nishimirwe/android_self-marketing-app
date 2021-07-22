package online.hellofriendz.selfmarketingapp;

import androidx.annotation.DrawableRes;

public class Cars {
    private String name;
    private String manufacturer;
    private int image;

    public Cars(String name, String manufacturer, @DrawableRes int i) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.image=i;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString()
    {
        return name+ " is from "+manufacturer;
    }
}

