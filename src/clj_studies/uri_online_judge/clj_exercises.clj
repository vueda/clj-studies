(ns clj-studies.uri-online-judge.clj-exercises)

;https://www.urionlinejudge.com.br/judge/pt/problems/view/2144

(defn hora-do-show [media]
  (cond
    (or (>= 1 media) (< media 13)) (println "Nao vai da nao")
    (or (>= 13 media) (< media 14)) (println "E 13")
    (or (>= 14 media) (< media 40)) (println "Bora, hora do show! BIIR!")
    (or (>= 40 media) (<= media 60)) (println "Ta saindo da jaula o monstro!")
    (> media 60) (println "AQUI E BODYBUILDER!!")))

(defn repeticao-maxima [peso n-repeticoes]
  (* peso (+ 1 (/ n-repeticoes 30))))

(defn ajuda-o-maluco-que-ta-doente [treino]
  (let [n-repeticoes (get treino 2)
        peso-esquerdo (get treino 0)
        peso-direito (get treino 1)
        esquerdo (repeticao-maxima peso-esquerdo n-repeticoes)
        direito (repeticao-maxima peso-direito n-repeticoes)
        media (/ (+ esquerdo direito) 2)]
    (hora-do-show media)
    media))

; treinos => [[1 2 1] [20 30 10] ...]
(defn body-build [treinos]
  (let [fibra (map ajuda-o-maluco-que-ta-doente treinos)
        trapezio-descendente (/ (reduce + fibra) (count fibra)) ]
    (println)
    (if (> trapezio-descendente 40)
      (println "Aqui nois constroi fibra rapaz! Nao e agua com musculo!")
      (println "Frango"))))