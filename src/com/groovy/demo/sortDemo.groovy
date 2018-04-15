package com.groovy.demo

class sortDemo {
    Map duplicates = [:]

    sortDemo(){
        duplicates.put("test",[54, 678, 334, 45])
    }

    void prepareList(){
        String today = new Date().format("MM-dd-yyyy")
        StringBuilder sbDuplicateRecords = new StringBuilder()
        duplicates.each {k,v->
            List declNums = v as List
            if(declNums && declNums.size()>1){
                declNums.sort()[0..declNums.size()-2].each {
                    sbDuplicateRecords << "\n\"$it, ${today} Added by script."
                }
            }
        }
        sbDuplicateRecords.each {print "$it"}

        new File("C:\\DEV\\Intellij\\GroovyPractice\\data\\DuplicateRecords.csv").with {
            sbDuplicateRecords.each {
                append "$it"
            }

        }
    }
}

