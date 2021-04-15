package com.company;

import com.company.Model.Data;

/**
 * @author Колосов Вячеслав
 * Итоговый проект
 * Вариант - 0 , 0 , 0
 * @version v2
 */
public class Main {

    public static void main(String[] args) {
        //Загрузка данных из файлов
        Data.loadingData();
        //Выгрузка данных в файлы
        Data.unloadingData();
    }
}
