package com.sallskapsresan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-10-19.
 */
public class Questions {

    private List<Question> persForm;

    public Questions() {
        this.persForm = new ArrayList<>();
    }

    public void setPersForm(List<Question> persForm) {
        this.persForm = persForm;
    }

    public List<Question> getPersForm() {
        return persForm;
    }
}
