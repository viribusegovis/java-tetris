# Tetris Java POO

A Java Swing implementation of Tetris built for the *Programação Orientada a Objetos* (POO) course at LEI (IPT). The project demonstrates OOP fundamentals - inheritance, polymorphism, cloning, and encapsulation - applied to classic Tetris mechanics.

## Overview

The board is rendered as monospace text inside a `JTextArea`, with all game logic (piece movement, rotation, collision, freezing, line generation) implemented from scratch, without any external game library.

The repo contains two NetBeans/Ant projects:

| Project | Description |
|---|---|
| [`TetrisFinal`](TetrisFinal) | The complete game: full Swing GUI (main menu, about, rules, options screens), configurable board size, all 7 tetromino types. **This is the project to run.** |
| [`SuperTetris`](SuperTetris) | An earlier prototype of the core `Block` / `BlockMatrix` / `Piece` classes, kept alongside unit tests used to validate the model before the final GUI was built. |

## Features

- All 7 standard tetrominoes (I, J, L, O, S, T, Z)
- Piece movement (left/right/down), rotation with basic wall-kick handling, and hard drop
- Configurable board dimensions (rows/columns) via spinner controls
- Main menu with About and Rules screens
- Random piece generation and game-over detection

## Architecture

Core game model (`TetrisFinal/src/classes`):

- **`Block`** - a single cell, identified by a `char` id (`.` for empty); supports copy-construction and cloning.
- **`Empty`** - a `Block` subclass representing an empty cell.
- **`BlockMatrix`** - a 2D grid of `Block`s with clone and in-place `rotate()` (matrix transpose + reverse) support.
- **`Piece`** (`classes.pieces`) - extends `BlockMatrix`, adds an `(x, y)` board position and movement methods. Each tetromino (`PieceI`, `PieceJ`, `PieceL`, `PieceO`, `PieceS`, `PieceT`, `PieceZ`) is a `Piece` subclass that hardcodes its own shape.
- **`Board`** - extends `BlockMatrix`, owns the currently falling `Piece`, and implements collision detection, movement validation, rotation with wall-kicks, freezing a piece into the board, and loss detection.

GUI (`TetrisFinal/src/gui`, NetBeans `.form`-backed): `MainMenu`, `Tetris` (game screen), `About`, `Rules`, `Options`.

## Requirements

- JDK 19+
- [Apache Ant](https://ant.apache.org/) (or open directly in [Apache NetBeans](https://netbeans.apache.org/), which the project was authored in)

## Running

```bash
cd TetrisFinal
ant run
```

Or open `TetrisFinal` as a project in NetBeans and run it directly.

## Controls

Movement is button-driven from the game screen: **◄ / ▼ / ►** to move, **↻** to rotate, **FALL** to hard-drop the current piece.

## Authors

Group project for LEI/POO, by Bruno Freitas ([@viribusegovis](https://github.com/viribusegovis)) and Vasco Alves ([@vascobrissos](https://github.com/vascobrissos)).
