package com.karlmarxindustries.grindripsum.service;

import com.karlmarxindustries.grindripsum.dao.DaoImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ServiceImpl {
    @Autowired
    DaoImpl dao = new DaoImpl();
    private List<String> STRING_LIST = dao.getStringList();
    private static final String[] SEN_TERMS = new String[]{".",".",".",".",".",".",".",".","!","?"};
    Random random = new Random(System.currentTimeMillis());
    static int DEF_SEN_MAX_WORDS = 12;
    static int DEF_SEN_MIN_WORDS = 4;
    private static final String WORD_SEPARATOR = " ";
    private static final String PHRASE_SEPARATOR = ",";


    public String getRandomWord() {
        return STRING_LIST.get(random.nextInt(STRING_LIST.size()));
    }
    public String buildSentence() {
        return buildSentence(random.nextInt(DEF_SEN_MAX_WORDS - DEF_SEN_MIN_WORDS) + DEF_SEN_MIN_WORDS);
    }
    public String buildSentence(int wordNum) {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.capitalize(getRandomWord()));
        for (int i=1; i < wordNum; i++) {
            sb.append(WORD_SEPARATOR);
            sb.append(getRandomWord());
        }
        sb.append(SEN_TERMS[random.nextInt(SEN_TERMS.length)]);
        return sb.toString();
    }
}
