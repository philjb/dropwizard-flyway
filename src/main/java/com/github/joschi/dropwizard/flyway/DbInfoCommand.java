package com.github.joschi.dropwizard.flyway;

import io.dropwizard.Configuration;
import io.dropwizard.db.DatabaseConfiguration;
import net.sourceforge.argparse4j.inf.Namespace;
import org.flywaydb.core.Flyway;

import static org.flywaydb.core.internal.info.MigrationInfoDumper.dumpToAsciiTable;

public class DbInfoCommand<T extends Configuration> extends AbstractFlywayCommand<T> {
    public DbInfoCommand(final DatabaseConfiguration<T> databaseConfiguration, final Class<T> configurationClass) {
        super("info", "Prints the details and status information about all the migrations.", databaseConfiguration, configurationClass);
    }

    @Override
    public void run(final Namespace namespace, final Flyway flyway) throws Exception {
        System.out.println(dumpToAsciiTable(flyway.info().all()));
    }
}
