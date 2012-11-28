(defproject clj-tesseract "1.0.0-SNAPSHOT"
  :description "Cojure wrapper for the Tesseract OCR software"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [clj-native "0.9.2-SNAPSHOT"]
                 [vision "1.0.0-SNAPSHOT"]]
  :jvm-opts ["-Djna.library.path=/usr/local/lib"]
  :native-path "/usr/local/lib:/opt/local/lib:/usr/lib"
  :aot [clj-tesseract.tesseract-api])
