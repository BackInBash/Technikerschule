; MegaParkhaus.asm
;
; Created: 16.07.2021 14:08:49
; Author : markus.brunsch
;
.INCLUDE "m16def.inc"

init:

	;R16 -> Initialisierungsregister
	ldi R16, 0xff

	;PORTA als AusgabePort
	out DDRA, R16

	;PORTB als EingabePort
	ldi R16, 0x00
	out DDRD, R16

	;PORTA null setzen (Weil pullup auf port A bei atmega16 aktiviert default)
	out PORTA, R16

	; Set Global Register
	ldi R20, 0b00000000 ; Geschlossen
	ldi R21, 0b00000000 ; Abgasalarm
	ldi R22, 0b00000000 ; Belegt
	
main:
	; Geschlossen Einlesen
	in R20, PIND
	andi R20, 0b00000100 ; Bit Mask Geschlossen
	subi R20, 0b00000100 ; R20 - 1 = 0
	brbc 1, closed ; Jump if not Zero

	; Abgasalarm Einlesen
	in R21, PIND
	andi R21, 0b00001000 ; Bit Mask Abgasalarm
	subi R21, 0b00001000 ; R21 - 1 = 0
	brbc 1, alarm ; Jump If not Zero

	; Belegt Berechnen
	andi R22, 0xF ; Check If R22 is 15 (ParkHaus voll)
	brbc 1, full ; Jump if full
	rjmp einfahrt

	closed:
		ldi R18, 0b10000000
		out PORTA, R18
		rjmp main

	alarm:
		ldi R18,  0b01000000
		out PORTA, R18
		rjmp main

	full:
		ldi R18, 0b00100000
		out PORTA, R18
		rjmp main

einfahrt:
	out PORTA, R16 ; Clear LEDs
	ldi R17, 0x00 ; Set Local 
	in R17, PIND  ; Load Value PINA

	; TasterEinfahrtZuweisung
	; R17 0bX0000000
	andi R17, 0b10000000
	brbc 1, main ; Jump if not Zero

	wait:
	in R17, PIND ; Read Lichtschranke
	andi R17, 0b01000000 ; Mask Lichtschranke
	brbc 1, wait ; Loop Lichtschranke
	
	inc R22 ; Increase Belegt Counter



	;subi R17, R20 ; Einfahrt - Geschlossen
	;brbc 1, R17

	; LichtschrankeEinfahrtZuwesiung
	; R17 0b0X000000
	andi R17, 0b01000000


	TasterEinfahrt:

	istGeschlossen:


ausfahrt:

