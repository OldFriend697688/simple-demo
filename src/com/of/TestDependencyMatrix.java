package com.of;

import com.of.controller.*;

public class TestDependencyMatrix {
    // 各种控制器类
    private static DataController dataController;
    private static DownloadController downloadController;
    private static GameController gameController;
    private static LoginController loginController;
    private static UserController userController;

    // 静态初始化代码块
    static {
        dataController = new DataController();
        downloadController = new DownloadController();
        gameController = new GameController();
        loginController = new LoginController();
        userController = new UserController();
    }
}
