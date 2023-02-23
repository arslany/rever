package com.rever;

import com.github.mvysny.vaadinboot.VaadinBoot;
import javax.validation.constraints.NotNull;

public class Main {
    public static void main(@NotNull String[] args) throws Exception {
        new VaadinBoot().withArgs(args).run();
    }

}
