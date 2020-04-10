package domain.command;

import java.util.Arrays;

public enum Command {
	ORDER("1"),
	PAY("2"),
	TERMINATE("3");

	private String number;

	Command(String number) {
		this.number = number;
	}

	public static Command of(String action) {
		return Arrays.stream(values())
			.filter(command -> command.number.equals(action))
			.findFirst()
			.orElseThrow(() -> new InvalidCommandException(InvalidCommandException.INVALID_COMMAND));
	}

	public boolean isOrder() {
		return ORDER.equals(this);
	}

	public boolean isPay() {
		return PAY.equals(this);
	}

	public boolean isTerminate() {
		return TERMINATE.equals(this);
	}
}
