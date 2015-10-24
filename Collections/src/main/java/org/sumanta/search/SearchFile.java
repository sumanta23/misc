package org.sumanta.search;

import java.io.File;

class SearchFile extends Thread {
    File Filedir;
    String Filename;

    public SearchFile(File d, String n) {
        Filedir = d;
        Filename = n;
    }

    public void run() {
        try {
            search(Filedir, Filename);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void search(File dir, String name) throws InterruptedException {

        if (dir.getName().toLowerCase().equals(name.toLowerCase())) {
            FilePath.getInstance().add(dir.getAbsolutePath());
            System.out.println(dir.getAbsolutePath());
        } else if (dir.isDirectory()) {
            String[] children = dir.list();
            SearchFile[] fs = new SearchFile[children.length];
            for (int i = 0; i < children.length; i++) {
                fs[i] = new SearchFile(new File(dir, children[i]), name);
                fs[i].start();
            }
            for (int i = 0; i < children.length; i++) {
                fs[i].join();
            }

        }
    }
}