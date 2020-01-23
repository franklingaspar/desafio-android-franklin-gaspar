package com.desafio_android_franklin_gaspar.model.to;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;

public class ResultadoPersonagem implements Parcelable {

    private Integer id;
    private String name;
    private String description;
    private Date modified;
    private String resourceURI;
    private Thumbnail thumbnail;

    protected ResultadoPersonagem(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        name = in.readString();
        description = in.readString();
        resourceURI = in.readString();
        thumbnail = in.readParcelable(Thumbnail.class.getClassLoader());
    }

    public static final Creator<ResultadoPersonagem> CREATOR = new Creator<ResultadoPersonagem>() {
        @Override
        public ResultadoPersonagem createFromParcel(Parcel in) {
            return new ResultadoPersonagem(in);
        }

        @Override
        public ResultadoPersonagem[] newArray(int size) {
            return new ResultadoPersonagem[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
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
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(resourceURI);
        dest.writeParcelable(thumbnail, flags);
    }
}
