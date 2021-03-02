;
; EinfacheAusgabe.asm
;
; Created: 02/03/2021 13:45:35
; Author : Markus
;

;==== Beschreibung des Programms====
; Nach Start des Programms soll eine LED leuchten.
; LED an PA0

;====Beginn des Programms====
.INCLUDE "m16def.inc" 		; Assembleranweisung: Definitionsdatei für ATmega16
							; einfügen.
							; Beinhaltet Namen zur einfacheren Programmierung
							; z. B. PORTA für das Ausgangsregister des Port A
							; .DEF PORTA = 0x1b (Speicheradresse)

;==== Initialisierung====
init:						; Sprungmarke/Label
							; Port A als Ausgang
		ldi R16, 0xff		; Assemblerbefehl „load immediate“
							; Register R16 mit dem Wert 0xff laden
		out DDRA, R16		; Assemblerbefehl „out“:
							; Inhalt von R16 wird nach I/O-Register DDRA ausgegeben
							; DDR-Register: Information, ob Aus- oder Eingang

;====Hauptprogramm====
main:
		sbi PORTA, 0		; Assemblerbefehl „set bit in I/O-Register“
							; Register PORTA – PA0 auf 1 setzen
							; Achtung: Befehl funktioniert nur mit den ersten 32
							; I/O-Registern
ende:
		jmp ende			; Endlosschleife