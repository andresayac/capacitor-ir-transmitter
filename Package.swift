// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorIrTransmitter",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapacitorIrTransmitter",
            targets: ["IrTransmitterPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "IrTransmitterPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/IrTransmitterPlugin"),
        .testTarget(
            name: "IrTransmitterPluginTests",
            dependencies: ["IrTransmitterPlugin"],
            path: "ios/Tests/IrTransmitterPluginTests")
    ]
)