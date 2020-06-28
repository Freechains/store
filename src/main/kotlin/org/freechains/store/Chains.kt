package org.freechains.store

import org.freechains.cli.main_cli

class Chains (store: Store) {
    init {
        store.cbs.add { v1,v2,v3 ->
            if (v1 == "chains") {
                when {
                    (v3 == "REM") -> main_cli(arrayOf(store.port, "chains", "leave", v2))
                    (v3 == "ADD") -> main_cli(arrayOf(store.port, "chains", "join",  v2))
                    else          -> main_cli(arrayOf(store.port, "chains", "join",  v2, v3))
                }
            }
        }
    }
}