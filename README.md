# Wordie
An open-source java implementation of the hit game [Wordle](https://www.powerlanguage.co.uk/wordle/).
## Features
- Unlimited rounds (Goodbye once a day puzzles :D)
- Implementation examples at the console level, and as a web app (WIP)
- Built with simple to implement classes in order to extend the gameplay functionality to any other service you want easily. 
## About
The gameplay of Wordie is meant to emulate the original as closely as possible in rule-set. That means each round consists of a randomly selected 5-letter word, and you have 6 tries to guess the word. Each time you guess a word, clues regarding matching letters will be shown.

The Wordie word-bank was created by parsing the top 18,000 words from the english TV/movie frequency list, 2006 ([Wiktionary](https://en.wiktionary.org/wiki/Wiktionary:Frequency_lists#TV_and_movie_scripts)) for 5-letter words, then curating the list for quality. Then the guess bank was created by merging that with a [wider english dictionary](https://github.com/dwyl/english-words) also limited to 5 letters. It does NOT use the Wordle banks at all, though in theory you could swap in any dictionary list for any language you'd like.
## Usage
(WIP)

## TODO
- Build web app
- Utilize optionals to avoid returning null values in Dictionary class
