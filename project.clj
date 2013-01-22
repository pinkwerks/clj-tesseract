(defproject clj-tesseract "1.0.0-SNAPSHOT"
  :description "Cojure wrapper for the Tesseract OCR software"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [vision "1.0.0-SNAPSHOT"]
                 [clj-native "0.9.1-SNAPSHOT"]]
  :jvm-opts ["-Djna.library.path=/home/pink/clojure/vision/resources/lib"]
  :aot [clj-tesseract.tesseract-api]
  :dev-dependencies [[leiningen/lein-swank "1.2.0-SNAPSHOT"]
                     [cdt "1.2"]])
