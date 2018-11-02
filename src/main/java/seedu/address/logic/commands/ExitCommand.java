package seedu.address.logic.commands;

import java.nio.file.InvalidPathException;

import seedu.address.commons.core.EventsCenter;
import seedu.address.commons.events.ui.ExitAppRequestEvent;
import seedu.address.commons.util.ImageMagickUtil;
import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;

/**
 * Terminates the program.
 */
public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "exit";

    public static final String MESSAGE_EXIT_ACKNOWLEDGEMENT = "Exiting Piconso as requested ...";

    @Override
    public CommandResult execute(Model model, CommandHistory history) {
        try {
            ImageMagickUtil.getTempFolderPath().toFile().delete();
        } catch (InvalidPathException e) {
            e.printStackTrace();
        }

        //PreviewImage.getCacheFolder().toFile().delete();
        EventsCenter.getInstance().post(new ExitAppRequestEvent());
        return new CommandResult(MESSAGE_EXIT_ACKNOWLEDGEMENT);
    }

}
