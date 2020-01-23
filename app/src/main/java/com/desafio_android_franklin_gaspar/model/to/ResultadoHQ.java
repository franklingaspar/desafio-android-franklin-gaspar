package com.desafio_android_franklin_gaspar.model.to;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;

public class ResultadoHQ implements Parcelable {

    private Integer id;
    private String description;
    private Thumbnail thumbnail;
    private String title;
    private List<Preco> prices;

    protected ResultadoHQ(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        description = in.readString();
        thumbnail = in.readParcelable(Thumbnail.class.getClassLoader());
        title = in.readString();
    }

    public static final Creator<ResultadoHQ> CREATOR = new Creator<ResultadoHQ>() {
        @Override
        public ResultadoHQ createFromParcel(Parcel in) {
            return new ResultadoHQ(in);
        }

        @Override
        public ResultadoHQ[] newArray(int size) {
            return new ResultadoHQ[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Preco> getPrices() {
        return prices;
    }

    public void setPrices(List<Preco> prices) {
        this.prices = prices;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(description);
        dest.writeParcelable(thumbnail, flags);
        dest.writeString(title);
    }
}
